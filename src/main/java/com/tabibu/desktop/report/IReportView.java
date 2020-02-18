package com.tabibu.desktop.report;

import java.util.HashMap;

public interface IReportView {
    void displayPieChartAnalytics(HashMap<String, Integer> reportCases);
    void displayLineChartAnalytics(HashMap<String, HashMap<String, Integer>> reportedCases);
}
