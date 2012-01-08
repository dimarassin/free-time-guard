package com.droz.ftg.entities;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Date: 1/7/12
 *
 * @author Dima Rassin
 */
@XStreamAlias("task")
//ziso can commit!!!
public class Task {
	private Long id;
	private String name;
	private String description;
	private Long duration;
	private boolean shared;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public boolean isShared() {
		return shared;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Task)) return false;

		Task that = (Task) o;

		return new EqualsBuilder()
				.append(this.name, that.name)
				.append(this.description, that.description)
				.append(this.duration, that.duration)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(name)
				.append(description)
				.append(duration)
				.toHashCode();
	}
}
