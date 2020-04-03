package com.PersonalProjectManagement.PersonalProjectManagement.repositories;

import com.PersonalProjectManagement.PersonalProjectManagement.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
}
