package org.moonlightcontroller.blocks;

import java.util.Map;

import org.moonlightcontroller.processing.BlockClass;
import org.moonlightcontroller.processing.ProcessingBlock;

public class ToDevice extends ProcessingBlock {

	private String devname;

	public ToDevice(String id, String devname){
		super(id);
		this.devname = devname;
	}

	public String getDevice() {
		return this.devname;
	}

	@Override
	public BlockClass getBlockClass() {
		return BlockClass.BLOCK_CLASS_TERMINAL;
	}

	@Override
	public String getBlockType() {
		return "ToDevice";
	}

	@Override
	protected void putConfiguration(Map<String, String> config) {
		config.put("devname", devname);
	}
    
	@Override
	protected ProcessingBlock spawn(String id) {
		return new ToDevice(id, this.getDevice());
	}
}
