package com.epam.workspacesapi.services;

import com.epam.commons.entity.Workspace;
import com.epam.workspacesapi.repository.WorkspaceRepository;
import com.epam.workspacesapi.services.interfaces.WorkspaceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkplaceService implements WorkspaceInterface {
    private final WorkspaceRepository workspaceRepository;

    @Override
    public Workspace findWorkspace(String id) {
        return workspaceRepository.getOne(id);
    }

    @Override
    public void addWorkspace(Workspace workspace) {
        workspaceRepository.save(workspace);
    }

//    public Workspace findWorkspace(String id) {
//        return workspaces.stream()
//                .filter(w -> StringUtils.equals(w.getId(), id))
//                .findFirst()
//                .orElseThrow(() -> new NoWorkplaceFoundException(format("No workspace found with id: %s", id)));
//    }
}
