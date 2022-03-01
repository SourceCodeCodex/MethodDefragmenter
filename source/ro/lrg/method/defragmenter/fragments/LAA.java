package ro.lrg.method.defragmenter.fragments;

import methoddefragmenter.metamodel.entity.MFragment;
import ro.lrg.xcore.metametamodel.IPropertyComputer;
import ro.lrg.xcore.metametamodel.PropertyComputer;

@PropertyComputer
public class LAA implements IPropertyComputer<Integer, MFragment> {
	@Override
	public Integer compute(MFragment arg0) {
		return arg0.getUnderlyingObject().getLocalAttrAccess();
	}
}
