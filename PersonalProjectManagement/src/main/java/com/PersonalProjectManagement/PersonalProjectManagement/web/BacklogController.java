package com.PersonalProjectManagement.PersonalProjectManagement.web;

import com.PersonalProjectManagement.PersonalProjectManagement.domain.ProjectTask;
import com.PersonalProjectManagement.PersonalProjectManagement.services.ProjectTaskService;
import com.PersonalProjectManagement.PersonalProjectManagement.services.ValidationMapErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
    @RequestMapping("/api/backlog")
    @CrossOrigin
    public class BacklogController {

        @Autowired
        private ProjectTaskService projectTaskService;

        @Autowired
        private ValidationMapErrorService mapValidationErrorService;


        @PostMapping("/{backlog_id}")
        public ResponseEntity<?> addPTtoBacklog(@Valid @RequestBody ProjectTask projectTask,
                                                BindingResult result, @PathVariable String backlog_id){

            ResponseEntity<?> errorMap = mapValidationErrorService.ValidationMapService(result);
            if (errorMap != null) return errorMap;

            ProjectTask projectTask1 = projectTaskService.addProjectTask(backlog_id, projectTask);

            return new ResponseEntity<ProjectTask>(projectTask1, HttpStatus.CREATED);

        }
        @GetMapping("/{backlog_id}")
        public Iterable<ProjectTask> getProjectBacklog(@PathVariable String backlog_id){
            return (projectTaskService.findBacklogById(backlog_id));
        }
        @GetMapping("/{backlog_id}/{pt_id}")
        public ResponseEntity<?> getProjectTask(@PathVariable String backlog_id, @PathVariable String pt_id){
            ProjectTask projectTask = projectTaskService.findPTByProjectSequence(backlog_id,pt_id);
            return new ResponseEntity<ProjectTask>(projectTask,HttpStatus.OK);
        }


    }

