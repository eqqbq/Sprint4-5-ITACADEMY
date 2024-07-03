package cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.controller;

import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.service.impl.BranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchWebController {

    @Autowired
    private BranchServiceImpl branchService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Branch Manager");
        return "home";
    }

    @GetMapping("/add")
    public String addBranch(Model model) {
        model.addAttribute("branchDTO", new BranchDTO());
        return "add";
    }

    @PostMapping("/add")
    public String submitBranch(@ModelAttribute("branchDTO") BranchDTO dto, Model model) {
        branchService.addBranch(dto);
        return "redirect:/branch/list";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model){
        BranchDTO dto = branchService.getOneBranch(id);
        model.addAttribute("branchDTO", dto);
        return "update-form";
    }

    @PostMapping("/update/{id}")
    public String updateBranch(@ModelAttribute("branchDTO") BranchDTO dto, Model model){
        branchService.updateBranch(dto);
        return "redirect:/branch/list";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<BranchDTO> listaBranches = branchService.getAllBranches();
        model.addAttribute("branches", listaBranches);
        return "list";
    }

    @PostMapping("/delete/{id}")
    public String deleteBranch(@PathVariable("id") Long id, Model model){
        branchService.deleteBranch(id);
        return "redirect:/branch/list";
    }
}
