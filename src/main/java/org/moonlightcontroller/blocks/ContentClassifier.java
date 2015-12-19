package org.moonlightcontroller.blocks;

import org.moonlightcontroller.processing.ProcessingBlock;
import java.util.Map;
import org.moonlightcontroller.processing.BlockClass;

public class ContentClassifier extends ProcessingBlock {
	private String[] pattern;

	public ContentClassifier(String id, String[] pattern) {
		super(id);
		this.pattern = pattern;
	}

	public String[] getPattern() {
		return pattern;
	}

	@Override
	public String getBlockType() {
		return null;
	}

	@Override
	public String toShortString() {
		return null;
	}

	@Override
	public ProcessingBlock clone() {
		return null;
	}

	@Override
	public BlockClass getBlockClass() {
		return BlockClass.BLOCK_CLASS_CLASSIFIER;
	}

	@Override
	protected void putConfiguration(Map<String, String> config) {
		config.put("pattern", this.pattern.toString());
	}

	@Override
	protected ProcessingBlock spawn(String id) {
		return new ContentClassifier(id, this.pattern);
	}
}
