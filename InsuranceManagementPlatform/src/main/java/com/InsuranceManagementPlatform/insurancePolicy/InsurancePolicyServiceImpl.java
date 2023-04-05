package com.InsuranceManagementPlatform.insurancePolicy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InsuranceManagementPlatform.client.Client;
import com.InsuranceManagementPlatform.client.ClientRepository;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	@Autowired
    private InsurancePolicyRepository policyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<InsurancePolicy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public InsurancePolicy getPolicyById(Long id) {
  	Optional<InsurancePolicy> optionalInsurancePolicy = policyRepository.findById(id);
		return optionalInsurancePolicy.get();
    }

    @Override
    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        Client client = clientRepository.findById(policy.getClient().getId()).orElseThrow();
        policy.setClient(client);
        return policyRepository.save(policy);
    }

    @Override
    public InsurancePolicy updatePolicy(Long id, InsurancePolicy policy) {
        InsurancePolicy existingPolicy = getPolicyById(id);
        existingPolicy.setPolicyNumber(policy.getPolicyNumber());
        existingPolicy.setType(policy.getType());
        existingPolicy.setCoverageAmount(policy.getCoverageAmount());
        existingPolicy.setPremium(policy.getPremium());
        existingPolicy.setStartDate(policy.getStartDate());
        existingPolicy.setEndDate(policy.getEndDate());
        return policyRepository.save(existingPolicy);
    }

    @Override
    public void deletePolicy(Long id) {
        InsurancePolicy policy = getPolicyById(id);
        policyRepository.delete(policy);
    }
}
