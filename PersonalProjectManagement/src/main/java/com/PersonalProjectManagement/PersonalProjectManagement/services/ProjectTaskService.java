package com.PersonalProjectManagement.PersonalProjectManagement.services;

import com.PersonalProjectManagement.PersonalProjectManagement.domain.Backlog;
import com.PersonalProjectManagement.PersonalProjectManagement.domain.Project;
import com.PersonalProjectManagement.PersonalProjectManagement.domain.ProjectTask;
import com.PersonalProjectManagement.PersonalProjectManagement.exceptions.ProjectNotFoundException;
import com.PersonalProjectManagement.PersonalProjectManagement.repositories.BacklogRepository;
import com.PersonalProjectManagement.PersonalProjectManagement.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService  {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){
        try{
            Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
            projectTask.setBacklog(backlog);
            Integer BacklogSequence  = backlog.getPTSequence();
            BacklogSequence++;
            backlog.setPTSequence(BacklogSequence);

            projectTask.setProjectSequence(projectIdentifier +"-"+ BacklogSequence);
            projectTask.setProjectIdentifier(projectIdentifier);


            if(projectTask.getStatus()==""|| projectTask.getStatus()==null){
                projectTask.setStatus("TO_DO");
            }
            if(projectTask.getPriority()==null){
                projectTask.setPriority(3);
            }



            return projectTaskRepository.save(projectTask);
        }catch (Exception e){
            throw new ProjectNotFoundException("Project not found");
        }



    }
   public Iterable<ProjectTask> findBacklogById(String id){
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }


}
