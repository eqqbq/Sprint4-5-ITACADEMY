package cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.service.impl;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.exception.BranchNotFoundException;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.repository.BranchRepository;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    private BranchDTO convertToDTO(Branch branch) {
        return new BranchDTO(branch.getPk_branchId(), branch.getBranchName(), branch.getBranchCountry());
    }

    private Branch convertToEntity(BranchDTO dto) {
        return new Branch(dto.getPk_branchId(), dto.getBranchCountry(), dto.getBranchName());
    }

    @Override
    public BranchDTO addBranch(BranchDTO dto) {
        return convertToDTO(branchRepository.save(convertToEntity(dto)));
    }

    @Override
    public BranchDTO updateBranch(BranchDTO dto) {
        Branch branchToUpdate = branchRepository.findById(dto.getPk_branchId()).orElseThrow(() -> new BranchNotFoundException("Branch not found by ID: " + (dto.getPk_branchId())));

        branchToUpdate.setBranchName(dto.getBranchName());
        branchToUpdate.setBranchCountry(dto.getBranchCountry());

        return convertToDTO(branchRepository.save(branchToUpdate));
    }

    @Override
    public void deleteBranch(Long id) {
        Branch branchToDelete = branchRepository.findById(id).orElseThrow(() -> new BranchNotFoundException("Branch not found by ID: " + id));

        branchRepository.deleteById(id);
    }

    @Override
    public BranchDTO getOneBranch(Long id) {
        return convertToDTO(branchRepository.findById(id).orElseThrow(() -> new BranchNotFoundException("Branch not found by ID: " + id)));
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
