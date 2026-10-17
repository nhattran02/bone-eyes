# linux-bb.org appends ~40 cape overlays (.dtbo) to KERNEL_DEVICETREE via
# :append:armv7a, which a plain assignment cannot undo. Re-setting the
# variable after parsing drops those appends, leaving only the DTB(s)
# selected for the machine (see KERNEL_DEVICETREE in local.conf).
python __anonymous() {
    dtbs = [f for f in d.getVar('KERNEL_DEVICETREE').split() if not f.endswith('.dtbo')]
    d.setVar('KERNEL_DEVICETREE', ' '.join(dtbs))
}
