package com.epam.workspacesapi.services.interfaces;

import com.epam.commons.entity.Workspace;
import org.springframework.boot.ApplicationArguments;

public interface WorkspaceInterface {
    Workspace findWorkspace(String id);
    void addWorkspace(Workspace workspace);
}
