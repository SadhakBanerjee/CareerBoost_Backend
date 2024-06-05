//package com.careerboost.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="job_list")
//public class JobList {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long JobId;
//	
//	private String JobDescription;
//	
//	private Long ExpectedExperience;
//	
//	private String SkillSet;
//	
//	private String Locations;
//
//	public Long getJobId() {
//		return JobId;
//	}
//
//	public void setJobId(Long jobId) {
//		JobId = jobId;
//	}
//
//	public String getJobDescription() {
//		return JobDescription;
//	}
//
//	public void setJobDescription(String jobDescription) {
//		JobDescription = jobDescription;
//	}
//
//	public Long getExpectedExperience() {
//		return ExpectedExperience;
//	}
//
//	public void setExpectedExperience(Long expectedExperience) {
//		ExpectedExperience = expectedExperience;
//	}
//
//	public String getSkillSet() {
//		return SkillSet;
//	}
//
//	public void setSkillSet(String skillSet) {
//		SkillSet = skillSet;
//	}
//
//	public String getLocations() {
//		return Locations;
//	}
//
//	public void setLocations(String locations) {
//		Locations = locations;
//	}
//}

package com.careerboost.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.careerboost.converter.SkillSetConverter;

import java.util.List;

@Entity
@Table(name = "job_list")
public class JobList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long JobId;
    
    private String JobDescription;
    
    private Long ExpectedExperience;
    
    @Convert(converter = SkillSetConverter.class)
    private List<String> SkillSet;
    
    private String Locations;

    // Getters and Setters

    public Long getJobId() {
        return JobId;
    }

    public void setJobId(Long jobId) {
        JobId = jobId;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }

    public Long getExpectedExperience() {
        return ExpectedExperience;
    }

    public void setExpectedExperience(Long expectedExperience) {
        ExpectedExperience = expectedExperience;
    }

    public List<String> getSkillSet() {
        return SkillSet;
    }

    public void setSkillSet(List<String> skillSet) {
        SkillSet = skillSet;
    }

    public String getLocations() {
        return Locations;
    }

    public void setLocations(String locations) {
        Locations = locations;
    }
}

