package com.epam.workspacesapi.controllers;

import com.epam.commons.api.WorkspaceAPI;
import com.epam.commons.entity.Workspace;
import com.epam.workspacesapi.services.WorkplaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspaces")
@Slf4j
@RequiredArgsConstructor
public class WorkplaceAPIController implements WorkspaceAPI {
    private final WorkplaceService workplaceService;

    @RequestMapping("/{id}")
    public Workspace getWorkspaceById(@PathVariable("id") String id) {
        return workplaceService.findWorkspace(id);
    }
}
