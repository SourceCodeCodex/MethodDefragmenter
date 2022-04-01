package ro.lrg.method.defragmenter.metamodel.fragments;

import methoddefragmenter.metamodel.entity.MFragment;
import ro.lrg.method.defragmenter.preferences.MethodDefragmenterPropertyStore;
import ro.lrg.method.defragmenter.utils.AbstractInternalCodeFragment;
import ro.lrg.method.defragmenter.utils.MetricsComputer;
import ro.lrg.xcore.metametamodel.IPropertyComputer;
import ro.lrg.xcore.metametamodel.PropertyComputer;

@PropertyComputer
public class FDP implements IPropertyComputer<Integer, MFragment> {
	@Override
	public Integer compute(MFragment arg0) {
		AbstractInternalCodeFragment abstractInternalCodeFragment = arg0.getUnderlyingObject();
		MetricsComputer metricsComputer = new MetricsComputer();
		MethodDefragmenterPropertyStore propertyStore = new MethodDefragmenterPropertyStore(abstractInternalCodeFragment.getIJavaProject());
		metricsComputer.computeDataAccesses(abstractInternalCodeFragment, abstractInternalCodeFragment.getAnalizedClass(), 
				propertyStore.isConsiderStaticFieldAccesses(), propertyStore.isLibraryCheck(), propertyStore.getMinBlockSize());
		return metricsComputer.getFDP();
	}
}