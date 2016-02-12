/*
 *
 * Copyright (c) 2016. Enterprise Architecture Group, EACG
 *
 * SPDX-License-Identifier:	MIT
 *
 */

package de.eacg.ecs.gradle.plugin

// Extension according to
// https://docs.gradle.org/current/userguide/custom_plugins.html
// Chapter 39.3. Getting input from the build
class EcsPluginExtension {
    def configurations = []

    String baseUrl = 'https://ecs-app.eacg.de'
    String apiPath = '/api/v1'

    String projectName
    String moduleName
    String moduleId

    String credentials
    String userName
    String apiKey

    Boolean skip = false
    Boolean skipTransfer = false
    Boolean verbose = false

    void configuration(String... confs) {
        for (String s in confs) {
            configurations << s
        }
    }

    def getConfigurations() {
        if (this.configurations.isEmpty()) {
            this.configurations << 'default'
        }
        return this.configurations as Set
    }
}