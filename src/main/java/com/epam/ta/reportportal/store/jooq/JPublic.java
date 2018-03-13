/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.store.jooq;


import com.epam.ta.reportportal.store.jooq.tables.JBugTrackingSystem;
import com.epam.ta.reportportal.store.jooq.tables.JDashboard;
import com.epam.ta.reportportal.store.jooq.tables.JDashboardWidget;
import com.epam.ta.reportportal.store.jooq.tables.JDefectFieldAllowedValue;
import com.epam.ta.reportportal.store.jooq.tables.JDefectFormField;
import com.epam.ta.reportportal.store.jooq.tables.JIssue;
import com.epam.ta.reportportal.store.jooq.tables.JIssueTicket;
import com.epam.ta.reportportal.store.jooq.tables.JIssueType;
import com.epam.ta.reportportal.store.jooq.tables.JIssueTypeProjectConfiguration;
import com.epam.ta.reportportal.store.jooq.tables.JItemTag;
import com.epam.ta.reportportal.store.jooq.tables.JLaunch;
import com.epam.ta.reportportal.store.jooq.tables.JLaunchTag;
import com.epam.ta.reportportal.store.jooq.tables.JLog;
import com.epam.ta.reportportal.store.jooq.tables.JOauthAccessToken;
import com.epam.ta.reportportal.store.jooq.tables.JOauthRegistration;
import com.epam.ta.reportportal.store.jooq.tables.JOauthRegistrationScope;
import com.epam.ta.reportportal.store.jooq.tables.JProject;
import com.epam.ta.reportportal.store.jooq.tables.JProjectConfiguration;
import com.epam.ta.reportportal.store.jooq.tables.JProjectEmailConfiguration;
import com.epam.ta.reportportal.store.jooq.tables.JProjectUser;
import com.epam.ta.reportportal.store.jooq.tables.JServerSettings;
import com.epam.ta.reportportal.store.jooq.tables.JTestItem;
import com.epam.ta.reportportal.store.jooq.tables.JTestItemResults;
import com.epam.ta.reportportal.store.jooq.tables.JTestItemStructure;
import com.epam.ta.reportportal.store.jooq.tables.JTicket;
import com.epam.ta.reportportal.store.jooq.tables.JUsers;
import com.epam.ta.reportportal.store.jooq.tables.JWidget;
import com.epam.ta.reportportal.store.jooq.udt.JParameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.UDT;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JPublic extends SchemaImpl {

    private static final long serialVersionUID = -237116931;

    /**
     * The reference instance of <code>public</code>
     */
    public static final JPublic PUBLIC = new JPublic();

    /**
     * The table <code>public.bug_tracking_system</code>.
     */
    public final JBugTrackingSystem BUG_TRACKING_SYSTEM = com.epam.ta.reportportal.store.jooq.tables.JBugTrackingSystem.BUG_TRACKING_SYSTEM;

    /**
     * The table <code>public.dashboard</code>.
     */
    public final JDashboard DASHBOARD = com.epam.ta.reportportal.store.jooq.tables.JDashboard.DASHBOARD;

    /**
     * The table <code>public.dashboard_widget</code>.
     */
    public final JDashboardWidget DASHBOARD_WIDGET = com.epam.ta.reportportal.store.jooq.tables.JDashboardWidget.DASHBOARD_WIDGET;

    /**
     * The table <code>public.defect_field_allowed_value</code>.
     */
    public final JDefectFieldAllowedValue DEFECT_FIELD_ALLOWED_VALUE = com.epam.ta.reportportal.store.jooq.tables.JDefectFieldAllowedValue.DEFECT_FIELD_ALLOWED_VALUE;

    /**
     * The table <code>public.defect_form_field</code>.
     */
    public final JDefectFormField DEFECT_FORM_FIELD = com.epam.ta.reportportal.store.jooq.tables.JDefectFormField.DEFECT_FORM_FIELD;

    /**
     * The table <code>public.issue</code>.
     */
    public final JIssue ISSUE = com.epam.ta.reportportal.store.jooq.tables.JIssue.ISSUE;

    /**
     * The table <code>public.issue_ticket</code>.
     */
    public final JIssueTicket ISSUE_TICKET = com.epam.ta.reportportal.store.jooq.tables.JIssueTicket.ISSUE_TICKET;

    /**
     * The table <code>public.issue_type</code>.
     */
    public final JIssueType ISSUE_TYPE = com.epam.ta.reportportal.store.jooq.tables.JIssueType.ISSUE_TYPE;

    /**
     * The table <code>public.issue_type_project_configuration</code>.
     */
    public final JIssueTypeProjectConfiguration ISSUE_TYPE_PROJECT_CONFIGURATION = com.epam.ta.reportportal.store.jooq.tables.JIssueTypeProjectConfiguration.ISSUE_TYPE_PROJECT_CONFIGURATION;

    /**
     * The table <code>public.item_tag</code>.
     */
    public final JItemTag ITEM_TAG = com.epam.ta.reportportal.store.jooq.tables.JItemTag.ITEM_TAG;

    /**
     * The table <code>public.launch</code>.
     */
    public final JLaunch LAUNCH = com.epam.ta.reportportal.store.jooq.tables.JLaunch.LAUNCH;

    /**
     * The table <code>public.launch_tag</code>.
     */
    public final JLaunchTag LAUNCH_TAG = com.epam.ta.reportportal.store.jooq.tables.JLaunchTag.LAUNCH_TAG;

    /**
     * The table <code>public.log</code>.
     */
    public final JLog LOG = com.epam.ta.reportportal.store.jooq.tables.JLog.LOG;

    /**
     * The table <code>public.oauth_access_token</code>.
     */
    public final JOauthAccessToken OAUTH_ACCESS_TOKEN = com.epam.ta.reportportal.store.jooq.tables.JOauthAccessToken.OAUTH_ACCESS_TOKEN;

    /**
     * The table <code>public.oauth_registration</code>.
     */
    public final JOauthRegistration OAUTH_REGISTRATION = com.epam.ta.reportportal.store.jooq.tables.JOauthRegistration.OAUTH_REGISTRATION;

    /**
     * The table <code>public.oauth_registration_scope</code>.
     */
    public final JOauthRegistrationScope OAUTH_REGISTRATION_SCOPE = com.epam.ta.reportportal.store.jooq.tables.JOauthRegistrationScope.OAUTH_REGISTRATION_SCOPE;

    /**
     * The table <code>public.project</code>.
     */
    public final JProject PROJECT = com.epam.ta.reportportal.store.jooq.tables.JProject.PROJECT;

    /**
     * The table <code>public.project_configuration</code>.
     */
    public final JProjectConfiguration PROJECT_CONFIGURATION = com.epam.ta.reportportal.store.jooq.tables.JProjectConfiguration.PROJECT_CONFIGURATION;

    /**
     * The table <code>public.project_email_configuration</code>.
     */
    public final JProjectEmailConfiguration PROJECT_EMAIL_CONFIGURATION = com.epam.ta.reportportal.store.jooq.tables.JProjectEmailConfiguration.PROJECT_EMAIL_CONFIGURATION;

    /**
     * The table <code>public.project_user</code>.
     */
    public final JProjectUser PROJECT_USER = com.epam.ta.reportportal.store.jooq.tables.JProjectUser.PROJECT_USER;

    /**
     * The table <code>public.server_settings</code>.
     */
    public final JServerSettings SERVER_SETTINGS = com.epam.ta.reportportal.store.jooq.tables.JServerSettings.SERVER_SETTINGS;

    /**
     * The table <code>public.test_item</code>.
     */
    public final JTestItem TEST_ITEM = com.epam.ta.reportportal.store.jooq.tables.JTestItem.TEST_ITEM;

    /**
     * The table <code>public.test_item_results</code>.
     */
    public final JTestItemResults TEST_ITEM_RESULTS = com.epam.ta.reportportal.store.jooq.tables.JTestItemResults.TEST_ITEM_RESULTS;

    /**
     * The table <code>public.test_item_structure</code>.
     */
    public final JTestItemStructure TEST_ITEM_STRUCTURE = com.epam.ta.reportportal.store.jooq.tables.JTestItemStructure.TEST_ITEM_STRUCTURE;

    /**
     * The table <code>public.ticket</code>.
     */
    public final JTicket TICKET = com.epam.ta.reportportal.store.jooq.tables.JTicket.TICKET;

    /**
     * The table <code>public.users</code>.
     */
    public final JUsers USERS = com.epam.ta.reportportal.store.jooq.tables.JUsers.USERS;

    /**
     * The table <code>public.widget</code>.
     */
    public final JWidget WIDGET = com.epam.ta.reportportal.store.jooq.tables.JWidget.WIDGET;

    /**
     * No further instances allowed
     */
    private JPublic() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.BUG_TRACKING_SYSTEM_ID_SEQ,
            Sequences.DASHBOARD_ID_SEQ,
            Sequences.DEFECT_FIELD_ALLOWED_VALUE_ID_SEQ,
            Sequences.DEFECT_FORM_FIELD_ID_SEQ,
            Sequences.ISSUE_TYPE_ID_SEQ,
            Sequences.ITEM_TAG_ID_SEQ,
            Sequences.LAUNCH_ID_SEQ,
            Sequences.LAUNCH_TAG_ID_SEQ,
            Sequences.LOG_ID_SEQ,
            Sequences.OAUTH_REGISTRATION_SCOPE_ID_SEQ,
            Sequences.PROJECT_CONFIGURATION_ID_SEQ,
            Sequences.PROJECT_EMAIL_CONFIGURATION_ID_SEQ,
            Sequences.PROJECT_ID_SEQ,
            Sequences.SERVER_SETTINGS_ID_SEQ,
            Sequences.TEST_ITEM_ITEM_ID_SEQ,
            Sequences.TICKET_ID_SEQ,
            Sequences.USERS_ID_SEQ,
            Sequences.WIDGET_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            JBugTrackingSystem.BUG_TRACKING_SYSTEM,
            JDashboard.DASHBOARD,
            JDashboardWidget.DASHBOARD_WIDGET,
            JDefectFieldAllowedValue.DEFECT_FIELD_ALLOWED_VALUE,
            JDefectFormField.DEFECT_FORM_FIELD,
            JIssue.ISSUE,
            JIssueTicket.ISSUE_TICKET,
            JIssueType.ISSUE_TYPE,
            JIssueTypeProjectConfiguration.ISSUE_TYPE_PROJECT_CONFIGURATION,
            JItemTag.ITEM_TAG,
            JLaunch.LAUNCH,
            JLaunchTag.LAUNCH_TAG,
            JLog.LOG,
            JOauthAccessToken.OAUTH_ACCESS_TOKEN,
            JOauthRegistration.OAUTH_REGISTRATION,
            JOauthRegistrationScope.OAUTH_REGISTRATION_SCOPE,
            JProject.PROJECT,
            JProjectConfiguration.PROJECT_CONFIGURATION,
            JProjectEmailConfiguration.PROJECT_EMAIL_CONFIGURATION,
            JProjectUser.PROJECT_USER,
            JServerSettings.SERVER_SETTINGS,
            JTestItem.TEST_ITEM,
            JTestItemResults.TEST_ITEM_RESULTS,
            JTestItemStructure.TEST_ITEM_STRUCTURE,
            JTicket.TICKET,
            JUsers.USERS,
            JWidget.WIDGET);
    }

    @Override
    public final List<UDT<?>> getUDTs() {
        List result = new ArrayList();
        result.addAll(getUDTs0());
        return result;
    }

    private final List<UDT<?>> getUDTs0() {
        return Arrays.<UDT<?>>asList(
            JParameter.PARAMETER);
    }
}