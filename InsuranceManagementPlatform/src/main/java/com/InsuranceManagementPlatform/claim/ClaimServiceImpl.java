package com.InsuranceManagementPlatform.claim;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InsuranceManagementPlatform.insurancePolicy.InsurancePolicy;
import com.InsuranceManagementPlatform.insurancePolicy.InsurancePolicyRepository;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private InsurancePolicyRepository policyRepository;

	@Override
	public List<Claim> getAllClaims() {
		return claimRepository.findAll();
	}

	@Override
	public Claim getClaimById(Long id) {
		Optional<Claim> optionalClaim = claimRepository.findById(id);
		return optionalClaim.get();
	}

//	  @Override
//	    public InsurancePolicy createPolicy(InsurancePolicy policy) {
//	        Client client = clientRepository.findById(policy.getClient().getId())
//	            .orElseThrow();
//	    	//Optional<Client> client = clientRepository.findById(policy.getClient().getId());
//	        policy.setClient(client);
//	        return policyRepository.save(policy);
//	    }
	
	@Override
	public Claim createClaim(Claim claim) {
		InsurancePolicy insurancePolicy = policyRepository.findById(claim.getInsurancePolicy().getId()).orElseThrow();
		//Client client = clientRepository.findById(claim.getClient().getId()).orElseThrow();
		claim.setInsurancePolicy(insurancePolicy);
		return claimRepository.save(claim);
	}

	@Override
	public Claim updateClaim(Long id, Claim claim) {
		Claim existingClaim = getClaimById(id);
		existingClaim.setClaimNumber(claim.getClaimNumber());
		existingClaim.setDescription(claim.getDescription());
		existingClaim.setClaimDate(claim.getClaimDate());
		existingClaim.setClaimStatus(claim.getClaimStatus());
		// existingClaim.setInsurancePolicy(claim.getInsurancePolicy());
		return claimRepository.save(existingClaim);
	}

	@Override
	public void deleteClaim(Long id) {
		Claim claim = getClaimById(id);
		claimRepository.delete(claim);
	}
}
