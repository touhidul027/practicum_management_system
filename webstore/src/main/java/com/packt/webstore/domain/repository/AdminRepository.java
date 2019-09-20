package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.dto.ChangeSupervisorDTO;

public interface AdminRepository {
    public abstract Supervisor getSupervisor(int supervisorId);

	public abstract boolean changeSupervisor(int studentId, int supervisorId);
}
