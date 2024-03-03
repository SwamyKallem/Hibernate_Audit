package com.hibernatedirty.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.hibernatedirty.customdirty.IgnoreDirtyProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "tutorials")
@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
public class Tutorial extends AuditEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @IgnoreDirtyProperty
  @Column(name = "published")
  private boolean published;
  
  @CreationTimestamp
 private LocalDateTime createdDate;
  
  @UpdateTimestamp
  private LocalDateTime updateDate;

 

  public Tutorial(String title, String description, boolean published,String auditUser) {
    this.title = title;
    this.description = description;
    this.published = published;
    this.auditUser = auditUser;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean isPublished) {
    this.published = isPublished;
  }
  
  

  public LocalDateTime getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(LocalDateTime createdDate) {
	this.createdDate = createdDate;
}

public LocalDateTime getUpdateDate() {
	return updateDate;
}

public void setUpdateDate(LocalDateTime updateDate) {
	this.updateDate = updateDate;
}

public void setId(long id) {
	this.id = id;
}



}
