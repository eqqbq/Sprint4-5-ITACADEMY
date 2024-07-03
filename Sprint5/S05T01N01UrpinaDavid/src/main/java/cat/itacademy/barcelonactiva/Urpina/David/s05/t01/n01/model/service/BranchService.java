package cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.service;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.dto.BranchDTO;

import java.util.List;

public interface BranchService {
    BranchDTO addBranch(BranchDTO dto);

    BranchDTO updateBranch(BranchDTO dto);

    void deleteBranch(Long id);

    BranchDTO getOneBranch(Long id);

    List<BranchDTO> getAllBranches();
}
