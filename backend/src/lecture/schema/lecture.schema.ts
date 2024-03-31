import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import mongoose from 'mongoose';
import { User } from 'src/user/user.schema';

@Schema()
export class Lecture {
  @Prop({ required: true })
  title: string;

  @Prop({ default: '' })
  description: string;

  @Prop({ required: true, type: mongoose.Schema.Types.ObjectId, ref: 'User' })
  presenter_id: User;

  @Prop({ default: false })
  is_end: boolean;

  @Prop()
  audio_file: string;

  @Prop()
  start_time: Date;
}

export const LectureSchema = SchemaFactory.createForClass(Lecture);
