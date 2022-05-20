package com.cydeo.repository;

import com.cydeo.entity.Task;
import com.cydeo.entity.User;
import com.cydeo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT  count (t)  FROM Task  t where t.project.projectCode=?1 and t.taskStatus <> 'Completed'")
    int totalNonCompletedTasks(String projectCode);

    @Query(value = "SELECT count (*) from  tasks t join  projects p on t.project_id=p.id " +
            "where p.project_code=?1 and t.task_status='COMPLETE'",nativeQuery = true)
    int totalCompletedTasks(String projectCode);
}
