package com.InsuranceManagementPlatform.insurancePolicy;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyService insurancePolicyService;

	@GetMapping
	public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicies() {
		List<InsurancePolicy> policies = insurancePolicyService.getAllPolicies();
		return new ResponseEntity<>(policies, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable Long id) {
		InsurancePolicy insurancePolicy = insurancePolicyService.getPolicyById(id);
		if (insurancePolicy == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(insurancePolicy);
	}

	@PostMapping
	public ResponseEntity<InsurancePolicy> createInsurancePolicy(@Valid @RequestBody InsurancePolicy insurancePolicy) {
		InsurancePolicy createdInsurancePolicy = insurancePolicyService.createPolicy(insurancePolicy);
		return ResponseEntity.created(URI.create("/api/policies/" + createdInsurancePolicy.getId()))
				.body(createdInsurancePolicy);
	}

	@PutMapping("/{id}")
	public ResponseEntity<InsurancePolicy> updateInsurancePolicy(@PathVariable Long id,
			@Valid @RequestBody InsurancePolicy insurancePolicy) {
		insurancePolicy.setId(id);
		InsurancePolicy updatedInsurancePolicy = insurancePolicyService.updatePolicy(id, insurancePolicy);
		if (updatedInsurancePolicy == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedInsurancePolicy);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteInsurancePolicy(@PathVariable Long id) {
		insurancePolicyService.deletePolicy(id);
		return ResponseEntity.noContent().build();
	}

}
