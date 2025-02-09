/**
 * MIT License
 * Copyright (c) 2018 yadong.zhang
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.zyd.shiro.business.entity;

import com.zyd.shiro.business.enums.ResourceTypeEnum;
import com.zyd.shiro.persistence.beans.SysResources;

import java.util.Date;
import java.util.List;


public class Resources {
    private SysResources sysResources;

    public Resources() {
        this.sysResources = new SysResources();
    }

    public Resources(SysResources sysResources) {
        this.sysResources = sysResources;
    }

    public SysResources getSysResources() {
        return this.sysResources;
    }

    public Long getId() {
        return this.sysResources.getId();
    }

    public void setId(Long id) {
        this.sysResources.setId(id);
    }

    public String getName() {
        return this.sysResources.getName();
    }

    public void setName(String name) {
        this.sysResources.setName(name);
    }

    public ResourceTypeEnum getType() {
        return this.sysResources.getType() != null ? ResourceTypeEnum.valueOf(this.sysResources.getType()) : null;
    }

    public void setType(ResourceTypeEnum type) {
        this.sysResources.setType(type.toString());
    }

    public String getUrl() {
        return this.sysResources.getUrl();
    }

    public void setUrl(String url) {
        this.sysResources.setUrl(url);
    }

    public String getPermission() {
        return this.sysResources.getPermission();
    }

    public void setPermission(String permission) {
        this.sysResources.setPermission(permission);
    }

    public Long getParentId() {
        return this.sysResources.getParentId();
    }

    public void setParentId(Long parentId) {
        this.sysResources.setParentId(parentId);
    }

    public Integer getSort() {
        return this.sysResources.getSort();
    }

    public void setSort(Integer sort) {
        this.sysResources.setSort(sort);
    }

    public boolean isAvailable() {
        Boolean value = this.sysResources.getAvailable();
        return value != null ? value : false;
    }

    public void setAvailable(boolean available) {
        this.sysResources.setAvailable(available);
    }

    public Boolean getExternal() {
        Boolean value = this.sysResources.getExternal();
        return null == value ? false : value;
    }

    public void setExternal(Boolean external) {
        this.sysResources.setExternal(external);
    }

    public String getIcon() {
        return this.sysResources.getIcon();
    }

    public void setIcon(String icon) {
        this.sysResources.setIcon(icon);
    }

    public Date getCreateTime() {
        return this.sysResources.getCreateTime();
    }

    public void setCreateTime(Date regTime) {
        this.sysResources.setCreateTime(regTime);
    }

    public Date getUpdateTime() {
        return this.sysResources.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.sysResources.setUpdateTime(updateTime);
    }

    public SysResources getParent() {
        return this.sysResources.getParent();
    }

    public void setParent(SysResources parent) {
        this.sysResources.setParent(parent);
    }

    public List<SysResources> getNodes() {
        return this.sysResources.getNodes();
    }

    public void setNodes(List<SysResources> nodes) {
        this.sysResources.setNodes(nodes);
    }
}

