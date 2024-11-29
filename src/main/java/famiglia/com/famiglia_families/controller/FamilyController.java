package famiglia.com.famiglia_families.controller;

import famiglia.com.famiglia_families.dto.CreateFamilyRequest;
import famiglia.com.famiglia_families.model.Family;
import famiglia.com.famiglia_families.service.Impl.FamilyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/families")
@RequiredArgsConstructor
public class FamilyController {
    private final FamilyServiceImpl familyService;

    @PostMapping
    public ResponseEntity<Family> createFamily(@RequestBody CreateFamilyRequest body) {
        Family createdFamily = familyService.createFamily(body);
        return new ResponseEntity<>(createdFamily, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Family> getFamilyById(@PathVariable Long id) {
        Family family = familyService.getFamilyById(id);
        return new ResponseEntity<>(family, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Family>> getAllFamilies() {
        List<Family> families = familyService.getAllFamilies();
        return new ResponseEntity<>(families, HttpStatus.OK);
    }
}
