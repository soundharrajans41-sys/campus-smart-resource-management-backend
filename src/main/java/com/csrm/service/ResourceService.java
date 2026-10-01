package com.csrm.service;

import com.csrm.entity.Resource;
import com.csrm.exception.ApiException;
import com.csrm.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResourceService {
    @Autowired ResourceRepository repo;

    public List<Resource> all() { return repo.findAll(); }

    public List<Resource> available(LocalDateTime start, LocalDateTime end) {
        return repo.findAvailable(start, end);
    }

    public Resource add(Resource r) {
        if (r.name == null || r.name.isBlank()) throw new ApiException(400, "Resource name is required");
        r.id = null;
        return repo.save(r);
    }

    public Resource update(Long id, Resource r) {
        Resource old = repo.findById(id).orElseThrow(() -> new ApiException(404, "Resource not found"));
        old.name = r.name;
        old.type = r.type;
        old.location = r.location;
        old.availability = r.availability;
        return repo.save(old);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new ApiException(404, "Resource not found");
        repo.deleteById(id);
    }
}
