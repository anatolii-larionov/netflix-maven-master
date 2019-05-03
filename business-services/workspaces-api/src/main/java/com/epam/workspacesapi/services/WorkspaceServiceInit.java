package com.epam.workspacesapi.services;

import com.epam.commons.entity.Workspace;
import com.epam.workspacesapi.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.epam.commons.entity.OSFamily.*;
import static com.epam.commons.entity.OSFamily.LINUX;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceInit implements ApplicationRunner {
    private final WorkspaceRepository workspaceRepository;

    private final List<Workspace> workspaces = Arrays.asList(
            new Workspace("0000001", 1, 1, randomUUID().toString(), WINDOWS),
            new Workspace("0000002", 1, 2, randomUUID().toString(), WINDOWS),
            new Workspace("0000003", 1, 3, randomUUID().toString(), WINDOWS),
            new Workspace("0000004", 1, 4, randomUUID().toString(), OSX),
            new Workspace("0000005", 1, 5, randomUUID().toString(), OSX),
            new Workspace("0000006", 1, 6, randomUUID().toString(), OSX),
            new Workspace("0000007", 1, 7, randomUUID().toString(), WINDOWS),
            new Workspace("0000008", 2, 1, randomUUID().toString(), WINDOWS),
            new Workspace("0000009", 2, 2, randomUUID().toString(), WINDOWS),
            new Workspace("0000010", 2, 3, randomUUID().toString(), OSX),
            new Workspace("0000011", 2, 4, randomUUID().toString(), OSX),
            new Workspace("0000012", 2, 5, randomUUID().toString(), WINDOWS),
            new Workspace("0000013", 2, 6, randomUUID().toString(), WINDOWS),
            new Workspace("0000014", 2, 7, randomUUID().toString(), LINUX),
            new Workspace("0000015", 2, 9, randomUUID().toString(), LINUX)
    );

    @Override
    public void run(ApplicationArguments args) throws Exception {
        workspaces.forEach(workspaceRepository::save);
    }
}
