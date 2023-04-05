package com.InsuranceManagementPlatform.claim;

import java.util.List;

public interface ClaimService {

	List<Claim> getAllClaims();

	Claim getClaimById(Long id);

	Claim createClaim(Claim claim);

	Claim updateClaim(Long id, Claim claim);

	void deleteClaim(Long id);
}
