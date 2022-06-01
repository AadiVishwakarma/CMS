package com.zee.zee5Dashboard.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.BeforeTVFilter;

@Service
public interface BeforeTvFilterCsvExportService {

	public void downloadCsvFile(PrintWriter printWriter, List<BeforeTVFilter> beforetvfilter);
}
