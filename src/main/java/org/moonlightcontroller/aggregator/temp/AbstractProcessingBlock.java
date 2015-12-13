package org.moonlightcontroller.aggregator.temp;


public abstract class AbstractProcessingBlock implements IProcessingBlock {
	
	protected abstract AbstractProcessingBlock spawn(String id);
	private boolean cloned = false;
	
	@Override
	public IProcessingBlock clone() {
		String newId;
		if (this.cloned) {
			newId = String.format("%s::%s", this.getId().substring(0, this.getId().indexOf("::")), UUIDGenerator.getSystemInstance().getUUID().toString());
		} else {
			newId = String.format("%s::%s", this.getId(), UUIDGenerator.getSystemInstance().getUUID().toString());
		}
		AbstractProcessingBlock clone = this.spawn(newId);
		clone.cloned = true;
		
		return clone;
	}
	
	@Override
	public String toString() {
		return String.format("[Block type: %s, id: %s]", this.getBlockType(), this.getId());
	}
	
	public String toShortString() {
		return String.format("[B id: %s]", this.getId());
	}

}
