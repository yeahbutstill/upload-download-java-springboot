package com.yeahbutstill.uploadanddownload.message;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseFile {
    private String name;
    private String url;
    private String type;
    private Long size;
}
