package com.hcl.airport.AirportManagementSystem.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.airport.AirportManagementSystem.entity.AdminDetails;
import com.hcl.airport.AirportManagementSystem.entity.HangarDetails;
import com.hcl.airport.AirportManagementSystem.entity.ManagerCredentials;
import com.hcl.airport.AirportManagementSystem.entity.ManagerDetails;
import com.hcl.airport.AirportManagementSystem.entity.PilotDetails;
import com.hcl.airport.AirportManagementSystem.entity.PlaneDetails;

@Service("amsService")
public class AMSServiceImpl implements AMSService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public AdminDetails validateAdmin(AdminDetails adminDetails) {

		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<AdminDetails> httpEntity = new HttpEntity<AdminDetails>(adminDetails, httpHeaders);
		return restTemplate
				.exchange("http://localhost:7074/validateadmin", HttpMethod.POST, httpEntity, AdminDetails.class)
				.getBody();
	}

	public PlaneDetails addPlaneRemote(PlaneDetails planeDetails) {

		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<PlaneDetails> httpEntity = new HttpEntity<PlaneDetails>(planeDetails, httpHeaders);
		return restTemplate.exchange("http://localhost:7070/addplane", HttpMethod.POST, httpEntity, PlaneDetails.class)
				.getBody();
	}

	@Override
	public PilotDetails addPilotRemote(PilotDetails pilotDetails) {

		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<PilotDetails> httpEntity = new HttpEntity<PilotDetails>(pilotDetails, httpHeaders);
		return restTemplate.exchange("http://localhost:7071/addpilot", HttpMethod.POST, httpEntity, PilotDetails.class)
				.getBody();

	}

	@Override
	public HangarDetails addHangarRemote(HangarDetails hangarDetails) {

		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<HangarDetails> httpEntity = new HttpEntity<HangarDetails>(hangarDetails, httpHeaders);
		return restTemplate.exchange("http://localhost:7072/addhangar", HttpMethod.POST, httpEntity, HangarDetails.class)
				.getBody();
	}

	@Override
	public ManagerDetails addManagerRemote(ManagerDetails managerDetails) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<ManagerDetails> httpEntity = new HttpEntity<ManagerDetails>(managerDetails, httpHeaders);
		return restTemplate.exchange("http://localhost:7073/addmanager", HttpMethod.POST, httpEntity, ManagerDetails.class)
				.getBody();
	}

	@Override
	public List<ManagerDetails> getManagersList() {
		
	    ResponseEntity<ManagerDetails[]> responseEntity= restTemplate.getForEntity("http://localhost:7073/getallmanagers", ManagerDetails[].class);
	    return  Arrays.asList(responseEntity.getBody());
	}
	
	@Override
	public ManagerDetails approveManagerRemote(ManagerDetails managerDetails)
	{
		 HttpHeaders headers = new HttpHeaders();
	     HttpEntity<ManagerDetails> entity = new HttpEntity<ManagerDetails>(managerDetails,headers);
	     return restTemplate.exchange( "http://localhost:7073/approvemanager", HttpMethod.PUT, entity, ManagerDetails.class).getBody();
	}
	
	@Override
	public ManagerDetails rejectManagerRemote(ManagerDetails managerDetails)
	{
		 HttpHeaders headers = new HttpHeaders();
	     HttpEntity<ManagerDetails> entity = new HttpEntity<ManagerDetails>(managerDetails,headers);
	     return restTemplate.exchange( "http://localhost:7073/rejectmanager", HttpMethod.PUT, entity, ManagerDetails.class).getBody();	
	}
	
	@Override
	public String validateManagerRemote(ManagerCredentials managerCredentials)
	{
	    ResponseEntity<ManagerDetails> responseEntity= restTemplate.getForEntity("http://localhost:7073/validatemanager/"+managerCredentials.getContactNumber(), ManagerDetails.class);

		ManagerDetails managerDetails=responseEntity.getBody();
		
		if(managerDetails !=null)
		{
			if(managerDetails.getApprovalStatus().equals("Accepted"))
			{
				if(managerDetails.getPassword().equals(managerCredentials.getPassword()))
				{
					return "success";
				}
				else
				{
					return "Invalid Password";
				}
			}
			else if(managerDetails.getApprovalStatus().equals("Pending"))
			{
			  return "Pending";
			}
			else
			{
				return "Rejected";
			}
		}
		else
		{
			return "Not exists";
		}
	}

	@Override
	public List<HangarDetails> getEmptyHangarDetails() {
		
		 ResponseEntity<HangarDetails[]> responseEntity= restTemplate.getForEntity("http://localhost:7072/getemptyhangars", HangarDetails[].class);
		    return  Arrays.asList(responseEntity.getBody());
    }
	
	@Override
	public String allocateHangarRemote(long hangarId,long planeId)
	{
		String response;
		HttpHeaders httpHeaders=new HttpHeaders();
	    HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
	    response=restTemplate.exchange("http://localhost:7070/allocatehangar/"+hangarId+"/"+planeId,HttpMethod.GET,entity,String.class).getBody();		
	    
	    if(response.equals("success"))
	    {
	    	restTemplate.exchange("http://localhost:7072/allocateplane/"+hangarId+"/"+planeId,HttpMethod.GET,entity,HangarDetails.class);
	    	return response;
	    }
	    else
	    {
	    	return response;
	    }
	}

	@Override
	public List<PilotDetails> getFreePilotDetailsRemote() {
		
		 ResponseEntity<PilotDetails[]> responseEntity= restTemplate.getForEntity("http://localhost:7071/getfreepilots", PilotDetails[].class);
		    return  Arrays.asList(responseEntity.getBody());
	}

	@Override
	public String allocatePilotRemote(long pilotId, long planeId) {

		String response;
		HttpHeaders httpHeaders=new HttpHeaders();
	    HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
	    
	    response=restTemplate.exchange("http://localhost:7070/allocatepilot/"+pilotId+"/"+planeId,HttpMethod.GET,entity,String.class).getBody();		
	    
	    if(response.equals("success"))
	    {
	    	restTemplate.exchange("http://localhost:7071/allocateplane/"+pilotId+"/"+planeId,HttpMethod.GET,entity,HangarDetails.class);
	    	return response;
	    }
	    else
	    {
	    	return response;
	    }}

	@Override
	public List<PlaneDetails> getAllRemotePlanes() {
		
		  ResponseEntity<PlaneDetails[]> responseEntity= restTemplate.getForEntity("http://localhost:7070/getallplanes", PlaneDetails[].class);
		    return  Arrays.asList(responseEntity.getBody());
	}

	@Override
	public List<PilotDetails> getAllremotePilots() {
		
		ResponseEntity<PilotDetails[]> responseEntity= restTemplate.getForEntity("http://localhost:7071/getallpilots", PilotDetails[].class);
	    return  Arrays.asList(responseEntity.getBody());
	}

	@Override
	public PilotDetails findRemotePilotById(long pilotId) {
		
		HttpHeaders httpHeaders=new HttpHeaders();
	    HttpEntity<PilotDetails> entity = new HttpEntity<PilotDetails>(httpHeaders);
		return  restTemplate.exchange("http://localhost:7071/findpilotbyid/"+pilotId,HttpMethod.GET,entity,PilotDetails.class).getBody();
	}

	@Override
	public PilotDetails updatePilot(PilotDetails pilotDetails) {

		 HttpHeaders headers = new HttpHeaders();
	     HttpEntity<PilotDetails> entity = new HttpEntity<PilotDetails>(pilotDetails,headers);
	     return restTemplate.exchange( "http://localhost:7071/updatePilot", HttpMethod.PUT, entity, PilotDetails.class).getBody();	
	}

	@Override
	public PlaneDetails findRemotePlaneById(long planeId) {
		
		HttpHeaders httpHeaders=new HttpHeaders();
	    HttpEntity<PlaneDetails> entity = new HttpEntity<PlaneDetails>(httpHeaders);
		return  restTemplate.exchange("http://localhost:7070/getplanebyid/"+planeId,HttpMethod.GET,entity,PlaneDetails.class).getBody();
	}

	@Override
	public PlaneDetails updateRemotePlane(PlaneDetails planeDetails) {
		
		 HttpHeaders headers = new HttpHeaders();
	     HttpEntity<PlaneDetails> entity = new HttpEntity<PlaneDetails>(planeDetails,headers);
	     return restTemplate.exchange( "http://localhost:7070/updateplanedetails", HttpMethod.PUT, entity, PlaneDetails.class).getBody();
	}
	
}
