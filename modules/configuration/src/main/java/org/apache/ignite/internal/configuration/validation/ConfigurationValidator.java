/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.configuration.validation;

import java.util.List;
import org.apache.ignite.configuration.validation.ValidationIssue;
import org.apache.ignite.internal.configuration.SuperRoot;
import org.apache.ignite.internal.configuration.tree.ConfigurationSource;

/**
 * Configuration validator.
 */
public interface ConfigurationValidator {

    /**
     * Validate configuration.
     *
     * @param cfg configuration in HOCON format.
     * @return List of validation results.
     */
    List<ValidationIssue> validateHocon(String cfg);

    /**
     * Validate configuration.
     *
     * @param src configuration.
     * @return List of validation results.
     */
    List<ValidationIssue> validate(ConfigurationSource src);

    /**
     * Validate configuration.
     *
     * @param newRoots New roots.
     * @return List of validation results.
     */
    List<ValidationIssue> validate(SuperRoot newRoots);

    /**
     * Validate configuration changes.
     *
     * @param oldRoots Old known roots.
     * @param newRoots New roots.
     * @return List of validation results.
     */
    List<ValidationIssue> validate(SuperRoot oldRoots, SuperRoot newRoots);
}
