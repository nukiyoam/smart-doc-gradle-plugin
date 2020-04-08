/*
 * smart-doc https://github.com/shalousun/smart-doc
 *
 * Copyright (C) 2019-2020 smart-doc
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.smartdoc.gradle.plugin;

import com.smartdoc.gradle.constant.GlobalConstants;
import com.smartdoc.gradle.task.PostmanTask;
import com.smartdoc.gradle.task.RestAdocTask;
import com.smartdoc.gradle.task.RestHtmlTask;
import com.smartdoc.gradle.task.RestMarkdownTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author yu 2020/2/16.
 */
public class SmartDocPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        //create html
        RestHtmlTask restHtmlTask = project.getTasks().create(GlobalConstants.REST_HTML_TASK, RestHtmlTask.class);
        restHtmlTask.setGroup(GlobalConstants.TASK_GROUP);

        // create adoc
        RestAdocTask restAdocTask = project.getTasks().create(GlobalConstants.REST_ADOC_TASK, RestAdocTask.class);
        restAdocTask.setGroup(GlobalConstants.TASK_GROUP);

        // create markdown
        RestMarkdownTask restMarkdownTask = project.getTasks().create(GlobalConstants.REST_MARKDOWN_TASK, RestMarkdownTask.class);
        restMarkdownTask.setGroup(GlobalConstants.TASK_GROUP);

        // create postman collection
        PostmanTask postmanTask = project.getTasks().create(GlobalConstants.POSTMAN_TASK, PostmanTask.class);
        postmanTask.setGroup(GlobalConstants.TASK_GROUP);

        // extend project-model to get our settings/configuration via nice configuration
        project.getExtensions().create(GlobalConstants.EXTENSION_NAME, SmartDocPluginExtension.class);
    }

}