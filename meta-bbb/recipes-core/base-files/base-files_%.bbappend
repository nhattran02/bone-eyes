# Show Jolly, the ASCII bear from gadgets.muse.ai, on login.
# Installed under its own name: meta-poky's distro-override motd
# (files/poky/motd) would otherwise win the FILESPATH lookup
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://jolly.motd"

do_install:append() {
	install -m 0644 ${WORKDIR}/jolly.motd ${D}${sysconfdir}/motd
}
