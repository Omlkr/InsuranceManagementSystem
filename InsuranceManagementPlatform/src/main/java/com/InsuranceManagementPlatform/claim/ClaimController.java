package com.InsuranceManagementPlatform.claim;

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
@RequestMapping("/api/claims")
public class ClaimController {

	@Autowired
	private ClaimService claimService;

	@GetMapping
	public ResponseEntity<List<Claim>> getAllClaim() {
		List<Claim> claim = claimService.getAllClaims();
		return new ResponseEntity<>(claim, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
		Claim claim = claimService.getClaimById(id);
		if (claim == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(claim);
		}
	}

	@PostMapping
	public ResponseEntity<Claim> createClaim(@Valid @RequestBody Claim claim) {
		Claim createClaim = claimService.createClaim(claim);
		return ResponseEntity.created(URI.create("api/claims/" + createClaim.getId())).body(createClaim);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @Valid @RequestBody Claim claim) {
		claim.setId(id);
		Claim updateClaim = claimService.updateClaim(id, claim);
		if (updateClaim == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updateClaim);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteClaim(@PathVariable Long id) {
		claimService.deleteClaim(id);
		return ResponseEntity.noContent().build();
	}

}
