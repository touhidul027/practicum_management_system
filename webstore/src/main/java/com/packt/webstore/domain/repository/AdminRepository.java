package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Supervisor;

public interface AdminRepository {
    public abstract Supervisor getSupervisor(int supervisorId);
}
