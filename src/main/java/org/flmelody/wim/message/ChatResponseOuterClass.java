// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ChatResponse.proto

package org.flmelody.wim.message;

public final class ChatResponseOuterClass {
  private ChatResponseOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChatResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChatResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\022ChatResponse.proto\032\037google/protobuf/ti" +
      "mestamp.proto\032\020ChatStatus.proto\"\221\001\n\014Chat" +
      "Response\022\024\n\014conversation\030\001 \001(\t\022\016\n\006random" +
      "\030\002 \001(\t\022\013\n\003seq\030\003 \001(\004\022-\n\ttimestamp\030\004 \001(\0132\032" +
      ".google.protobuf.Timestamp\022\037\n\nchatStatus" +
      "\030\005 \001(\0162\013.ChatStatusB\034\n\030org.flmelody.wim." +
      "messageP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          ChatStatusOuterClass.getDescriptor(),
        });
    internal_static_ChatResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ChatResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChatResponse_descriptor,
        new String[] { "Conversation", "Random", "Seq", "Timestamp", "ChatStatus", });
    com.google.protobuf.TimestampProto.getDescriptor();
    ChatStatusOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
