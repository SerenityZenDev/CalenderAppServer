package org.example.calenderappserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {

    @CreatedDate
    @Column(updatable = false, name = "CREATEAT")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

//    @LastModifiedDate
//    @Column
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime modifiedAt;
}