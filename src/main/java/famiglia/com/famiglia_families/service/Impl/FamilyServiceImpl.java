package famiglia.com.famiglia_families.service.Impl;

import famiglia.com.famiglia_families.dto.CreateFamilyRequest;
import famiglia.com.famiglia_families.model.Family;
import famiglia.com.famiglia_families.model.UserFamily;
import famiglia.com.famiglia_families.repository.FamilyRepository;
import famiglia.com.famiglia_families.repository.UserFamilyRepository;
import famiglia.com.famiglia_families.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService {
    private final FamilyRepository familyRepository;
    private final UserFamilyRepository userFamilyRepository;

    @Override
    public Family createFamily(CreateFamilyRequest body) {
        Family family = new Family();
        family.setTitle(body.getTitle());
        family.setCreatedAt(LocalDateTime.now());
        family.setCreatorId(body.getCreatorId());
        Family createdFamily = familyRepository.save(family);

        UserFamily userFamily = new UserFamily();
        userFamily.setFamily(createdFamily);
        userFamily.setUserId(body.getCreatorId());
        userFamily.setAssignedAt(LocalDateTime.now());

        userFamilyRepository.save(userFamily);

        return createdFamily;
    }

    @Override
    public Family getFamilyById(Long id) {
        return null;
    }

    @Override
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    @Override
    public Family updateFamily(Long id, Family family) {
        return null;
    }

    @Override
    public void deleteFamily(Long id) {

    }
}
