package famiglia.com.famiglia_families.service;

import famiglia.com.famiglia_families.dto.CreateFamilyRequest;
import famiglia.com.famiglia_families.model.Family;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FamilyService {
    Family createFamily(CreateFamilyRequest body);
    Family getFamilyById(Long id);
    List<Family> getAllFamilies();
    Family updateFamily(Long id, Family family);
    void deleteFamily(Long id);
}
