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

package org.apache.ignite.internal.schema;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.UUID;

/**
 * Enumeration of all supported value generators that could be used as a default value provider
 * (i.e. could be specified as a default in column definition).
 */
public enum DefaultValueGenerator {
    /** Generator that generates random UUID string. */
    GEN_RANDOM_UUID("genRandomUuid", String.class);

    private final MethodHandle methodHandle;

    DefaultValueGenerator(String methodName, Class<?> resultCls) {
        try {
            this.methodHandle = MethodHandles.lookup().findStatic(
                    DefaultValueGenerator.class, methodName, MethodType.methodType(resultCls)
            );
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    /** Returns next value. */
    public Object next() {
        try {
            return methodHandle.invoke();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    /** Returns random UUID string. */
    @SuppressWarnings("unused") // actually method is called via reflection
    public static String genRandomUuid() {
        return UUID.randomUUID().toString();
    }
}
