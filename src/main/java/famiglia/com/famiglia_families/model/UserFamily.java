package famiglia.com.famiglia_families.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserFamilies")
public class UserFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "assigned_at")
    private Long assignedAt;
}