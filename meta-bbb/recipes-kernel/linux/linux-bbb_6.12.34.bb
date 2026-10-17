SUMMARY = "BeagleBoard.org Linux kernel for BeagleBone Black"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

COMPATIBLE_MACHINE = "beaglebone"

inherit kernel

# Pinned to the BeagleBoard.org 6.12.34 32-bit release (TI SDK 11.01.04 base)
SRC_URI = "git://github.com/nhattran02/bbb-linux-kernel.git;protocol=https;branch=v6.12.34-ti-arm32-r12"
SRCREV = "9e419b26243bd7efcd103ae0f6456f828592b34b"
PV = "6.12.34+git"

S = "${WORKDIR}/git"

# GCC plugins used by the kernel build
DEPENDS += "gmp-native libmpc-native"

# Use the in-tree BeagleBoard.org defconfig
KERNEL_CONFIG_COMMAND = "oe_runmake -C ${S} O=${B} bb.org_defconfig"
KERNEL_LOCALVERSION = "-ti"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
