package com.asc.als.scrapper.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;

@Configuration
@ConfigurationProperties(prefix = "scrapper.naver.datalab")
public class NaverDatalabConfiguration {
    @NotBlank
    private String totalCoronavirusCasesKey;
    @NotBlank
    private String totalCoronavirusDeathsKey;
    @NotBlank
    private String totalCoronavirusRecoveredKey;
    @NotBlank
    private String activeCasesPanelHeadingKey;
    @NotBlank
    private String closedCasesPanelHeadingKey;
    @NotBlank
    private String siteUrl;
    @NotBlank
    private String reportPath;
    @NotBlank
    private String reportFileName;

    public String getTotalCoronavirusCasesKey() {
        return totalCoronavirusCasesKey;
    }

    public void setTotalCoronavirusCasesKey(String totalCoronavirusCasesKey) {
        this.totalCoronavirusCasesKey = totalCoronavirusCasesKey;
    }

    public String getTotalCoronavirusDeathsKey() {
        return totalCoronavirusDeathsKey;
    }

    public void setTotalCoronavirusDeathsKey(String totalCoronavirusDeathsKey) {
        this.totalCoronavirusDeathsKey = totalCoronavirusDeathsKey;
    }

    public String getTotalCoronavirusRecoveredKey() {
        return totalCoronavirusRecoveredKey;
    }

    public void setTotalCoronavirusRecoveredKey(String totalCoronavirusRecoveredKey) {
        this.totalCoronavirusRecoveredKey = totalCoronavirusRecoveredKey;
    }

    public String getActiveCasesPanelHeadingKey() {
        return activeCasesPanelHeadingKey;
    }

    public void setActiveCasesPanelHeadingKey(String activeCasesPanelHeadingKey) {
        this.activeCasesPanelHeadingKey = activeCasesPanelHeadingKey;
    }

    public String getClosedCasesPanelHeadingKey() {
        return closedCasesPanelHeadingKey;
    }

    public void setClosedCasesPanelHeadingKey(String closedCasesPanelHeadingKey) {
        this.closedCasesPanelHeadingKey = closedCasesPanelHeadingKey;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }
}
