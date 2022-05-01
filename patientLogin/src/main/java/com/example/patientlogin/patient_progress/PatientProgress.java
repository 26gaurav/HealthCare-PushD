package com.example.patientlogin.patient_progress;

import com.example.patientlogin.appuser.AppUser;
import com.example.patientlogin.section.Section;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Entity
public class PatientProgress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pat_id", nullable = false)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pat_id") // this is the name of the column i.e. pat_id
    private AppUser appUser;

//    @Column
//    private Long pat_id;

//    @OneToOne
//    @JoinColumn(name = "id")
//    private AppUser appUser;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Section section;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
    @JsonManagedReference
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
