#!/usr/bin/env python

from lxml import etree as ET

import os


DEFAULT_PATH_PREFIX='.'
DEFAULT_NIFI_VERSION='1.5.0'
DEFAULT_NODE_COUNT='1'
DEFAULT_TASK_NAME='nifi-0-node'
DEFAULT_FRAMEWORK_NAME='nifi'
DEFAULT_TLD='autoip.dcos.thisdcos.directory'

NIFI_AUTHORIZERS_XML_TEMPLATE = '{}/nifi-scheduler/authorizers.xml.mustache'

NIFI_NODE_KEY_TEMPLATE = 'Node Identity {}'
NIFI_NODE_TEXT_TEMPLATE = 'CN=nifi-{}-node.{}.{}, OU=NIFI'

mesos_sandbox = os.getenv('MESOS_SANDBOX', DEFAULT_PATH_PREFIX)
framework_name = os.getenv('FRAMEWORK_NAME', DEFAULT_FRAMEWORK_NAME)
nifi_node_count = os.getenv('NODE_COUNT', DEFAULT_NODE_COUNT)

nifi_authorizers_xml_file = NIFI_AUTHORIZERS_XML_TEMPLATE.format(
        mesos_sandbox)

parser = ET.XMLParser(remove_blank_text=True)
tree = ET.parse(nifi_authorizers_xml_file, parser)
root = tree.getroot()

authorizer = root.find('authorizer')

for i in range(0, int(nifi_node_count)):
    element = ET.SubElement(authorizer, 
                               'property', 
                               dict(name=NIFI_NODE_KEY_TEMPLATE.format(
                                   str(i))))
    element.text = NIFI_NODE_TEXT_TEMPLATE.format(
            str(i),
            framework_name,
            DEFAULT_TLD)

with open(nifi_authorizers_xml_file, 'w') as nifi_authorizer_xml:
    nifi_authorizer_xml.write(ET.tostring(root, 
        pretty_print=True, 
        encoding='unicode'))
