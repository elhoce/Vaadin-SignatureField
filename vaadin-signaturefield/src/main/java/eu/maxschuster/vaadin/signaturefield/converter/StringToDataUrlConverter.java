/*
 * Copyright 2014 Max Schuster
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.maxschuster.vaadin.signaturefield.converter;

import com.vaadin.data.Converter;
import com.vaadin.data.Result;
import com.vaadin.data.ValueContext;

import eu.maxschuster.dataurl.DataUrl;
import eu.maxschuster.dataurl.DataUrlSerializer;
import eu.maxschuster.dataurl.IDataUrlSerializer;
import java.net.MalformedURLException;

/**
 * A converter that converts from a RFC 2397 data url {@link String} to 
 * a {@link DataUrl} and back.
 *
 * @author Max Schuster
 */
public class StringToDataUrlConverter implements Converter<String, DataUrl> {

    private static final long serialVersionUID = 2L;

    private final IDataUrlSerializer serializer;
    
    public StringToDataUrlConverter(IDataUrlSerializer serializer) {
        this.serializer = serializer;
    }

    public StringToDataUrlConverter() {
        this(new DataUrlSerializer());
    }

    @Override
    public Result<DataUrl> convertToModel(String value, ValueContext context) {
        try {
            return Result.ok(value == null ? null : serializer.unserialize(value));
        } catch (MalformedURLException e) {
            return Result.error(e.getMessage());
        }
    }

    @Override
    public String convertToPresentation(DataUrl value, ValueContext context) {
        try {
            return value == null ? null : serializer.serialize(value);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
