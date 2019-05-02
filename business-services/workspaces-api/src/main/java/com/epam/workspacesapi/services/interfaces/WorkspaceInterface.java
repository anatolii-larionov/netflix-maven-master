package com.epam.workspacesapi.services.interfaces;

import com.epam.commons.entity.Workspace;

public interface WorkspaceInterface {
    Workspace findWorkspace(String id);
}
