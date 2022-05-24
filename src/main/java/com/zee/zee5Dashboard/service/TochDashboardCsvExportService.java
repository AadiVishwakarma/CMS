package com.zee.zee5Dashboard.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.TochDashboard;


@Service
public interface TochDashboardCsvExportService {

	public void downloadCsvFile(PrintWriter printWriter, List<TochDashboard> tochdashboard);
}
